"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ClientController = void 0;
const client_repository_1 = require("../repository/client.repository");
class ClientController {
    constructor(repository = new client_repository_1.ClientRepository()) {
        this.getAllController = (req, res) => {
            let client = this.clients.getAll();
            res.json(client);
        };
        this.getByIdController = (req, res) => {
            let code = parseInt(req.params.id);
            let client = this.clients.getById(code);
            if (client) {
                res.json(client);
            }
            else {
                res.status(404).json({
                    message: "Client not found"
                });
            }
        };
        this.createController = (req, res) => {
            let client = this.clients.create(req.body);
            res.status(201).json(client);
        };
        this.updateController = (req, res) => {
            let code = parseInt(req.params.id);
            let updateClient = this.clients.update(code, req.body);
            if (updateClient) {
                res.json(updateClient);
            }
            else {
                res.status(404).json({
                    message: "Client not found"
                });
            }
        };
        this.deleteController = (req, res) => {
            let code = parseInt(req.params.id);
            let deleteClient = this.clients.delete(code);
            if (deleteClient) {
                res.status(200).json({
                    message: "Client deleted"
                });
            }
            else {
                res.status(404).json({
                    message: "Client not found"
                });
            }
        };
        this.clients = repository;
    }
}
exports.ClientController = ClientController;
//# sourceMappingURL=client.controller.js.map