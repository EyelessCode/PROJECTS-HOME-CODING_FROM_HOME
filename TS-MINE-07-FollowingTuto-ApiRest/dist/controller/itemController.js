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
exports.deleteItem = exports.createItem = exports.update = exports.getItems = exports.getItem = void 0;
const error_handle_1 = require("../util/error.handle");
const itemService_1 = require("../service/itemService");
const getItem = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_GET_ITEM');
    }
};
exports.getItem = getItem;
const getItems = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_GET_ITEMS');
    }
};
exports.getItems = getItems;
const update = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_UPDATE_ITEM');
    }
};
exports.update = update;
const createItem = (_a, res_1) => __awaiter(void 0, [_a, res_1], void 0, function* ({ body }, res) {
    try {
        const responseItem = yield (0, itemService_1.insertItem)(body);
        res.send(responseItem);
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_CREATE_ITEM', error);
    }
});
exports.createItem = createItem;
const deleteItem = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_DELETE_ITEM');
    }
};
exports.deleteItem = deleteItem;
//# sourceMappingURL=itemController.js.map