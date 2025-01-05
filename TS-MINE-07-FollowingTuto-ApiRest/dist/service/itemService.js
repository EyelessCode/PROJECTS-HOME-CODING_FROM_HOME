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
exports.insertItem = void 0;
const client_1 = require("@prisma/client");
const prisma = new client_1.PrismaClient();
const insertItem = (carDAta) => __awaiter(void 0, void 0, void 0, function* () {
    try {
        const responseInsert = yield prisma.Car.create({
            data: carDAta
        });
        return responseInsert;
    }
    catch (error) {
        console.error(`Error to insert a Car!`, error);
        throw new Error(`It was not possible to insert a Car!`);
    }
});
exports.insertItem = insertItem;
//# sourceMappingURL=itemService.js.map