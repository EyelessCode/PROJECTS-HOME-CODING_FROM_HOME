"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const client_controller_1 = require("../controller/client.controller");
const router = (0, express_1.Router)();
const controller = new client_controller_1.ClientController();
router.get('/client', controller.getAllController);
router.get('/client:id', controller.getByIdController);
router.post('/client/', controller.createController);
router.put('/client:id', controller.updateController);
router.delete('/client/:id', controller.deleteController);
exports.default = router;
//# sourceMappingURL=client.routes.js.map