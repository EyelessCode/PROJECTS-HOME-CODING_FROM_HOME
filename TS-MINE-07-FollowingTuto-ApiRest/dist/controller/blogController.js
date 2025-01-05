"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.deleteItem = exports.createItem = exports.update = exports.getItems = exports.getItem = void 0;
const error_handle_1 = require("../util/error.handle");
const getItem = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_GET_BLOG');
    }
};
exports.getItem = getItem;
const getItems = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_GET_BLOGS');
    }
};
exports.getItems = getItems;
const update = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_UPDATE_BLOG');
    }
};
exports.update = update;
const createItem = ({ body }, res) => {
    try {
        res.send(body);
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_CREATE_BLOG');
    }
};
exports.createItem = createItem;
const deleteItem = (req, res) => {
    try {
    }
    catch (error) {
        (0, error_handle_1.handleHttp)(res, 'ERROR_DELETE_BLOG');
    }
};
exports.deleteItem = deleteItem;
//# sourceMappingURL=blogController.js.map