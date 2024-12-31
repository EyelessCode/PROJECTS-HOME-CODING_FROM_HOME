"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const client_repository_1 = require("./repository/client.repository");
let repository = new client_repository_1.ClientRepository();
repository.getAll().forEach((client) => console.log(`IC: ${client.ic}, name: ${client.name}`));
repository.delete(6);
repository.getAll().forEach((client) => console.log(`IC: ${client.ic}, name: ${client.name}`));
//# sourceMappingURL=app.test.js.map