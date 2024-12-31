"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ClientRepository = void 0;
const client_data_1 = require("../data/client.data");
class ClientRepository {
    constructor() {
        this.clientes = client_data_1.OBJECT_CLIENT;
    }
    getAll() {
        return this.clientes;
    }
    getById(code) {
        return this.clientes.find((clientFind) => clientFind.id === code);
    }
    create(client) {
        this.clientes.push(client);
        return client;
    }
    update(code, client) {
        let index = this.clientes.findIndex((indexClient) => indexClient.id === code);
        if (index !== 1) {
            this.clientes[index] = Object.assign(Object.assign({}, client), { id: code });
            return this.clientes[index];
        }
        return undefined;
    }
    delete(code) {
        let index = this.clientes.findIndex((indexClient) => indexClient.id === code);
        if (index !== -1) {
            this.clientes.splice(index, 1);
            return true;
        }
        return false;
    }
}
exports.ClientRepository = ClientRepository;
//# sourceMappingURL=client.repository.js.map