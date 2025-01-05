"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
require("dotenv/config");
const pg_1 = require("pg");
function dbConnection() {
    return __awaiter(this, void 0, void 0, function* () {
        const connect = new pg_1.Pool({
            connectionString: process.env.DB_URI
        });
        try {
            const client = yield connect.connect();
            console.log(`DB CONNECTED`);
            client.release();
        }
        catch (error) {
            console.error(`Error to connect DB!`);
            throw error;
        }
    });
}
exports.default = dbConnection;
//# sourceMappingURL=postgreSql.js.map