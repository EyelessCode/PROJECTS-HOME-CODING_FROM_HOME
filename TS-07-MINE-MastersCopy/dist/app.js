"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const app = (0, express_1.default)();
const PORT = 4000;
app.use(express_1.default.json());
app.get('/api', (req, res) => {
    res.send(`Hola tu putamadre!`);
});
app.listen(PORT, () => console.log(`Your server was connected in the ${PORT} PORT!`));
//# sourceMappingURL=app.js.map