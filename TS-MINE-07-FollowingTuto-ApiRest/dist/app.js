"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
require("dotenv/config");
const express_1 = __importDefault(require("express"));
const cors_1 = __importDefault(require("cors"));
const router_1 = require("./router");
const postgreSql_1 = __importDefault(require("./config/postgreSql"));
const PORT = process.env.PORT || 4000;
const app = (0, express_1.default)();
app.use((0, cors_1.default)());
app.use(express_1.default.json());
app.use(router_1.router);
(0, postgreSql_1.default)().then(() => console.log(`Connection with 'App.ts' already!`));
app.listen(PORT, () => console.log(`Listenning in '${PORT}' PORT`));
//# sourceMappingURL=app.js.map