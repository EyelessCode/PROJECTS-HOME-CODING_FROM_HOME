"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const client_routes_1 = __importDefault(require("./routes/client.routes"));
const path_1 = __importDefault(require("path"));
const app = (0, express_1.default)();
const PORT = 4000;
app.use(express_1.default.json());
app.get('/', (req, res) => {
    res.sendFile(path_1.default.join(__dirname, '../public/index.html'));
});
app.get('/client', (req, res) => {
    res.sendFile(path_1.default.join(__dirname, '../public/getIndex.html'));
});
app.use('/api', client_routes_1.default);
app.listen(PORT, () => console.log(`Your server was connected in the ${PORT} PORT!`));
//# sourceMappingURL=app.js.map