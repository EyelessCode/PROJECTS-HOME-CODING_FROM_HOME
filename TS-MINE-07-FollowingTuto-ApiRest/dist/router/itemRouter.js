"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.router = void 0;
const express_1 = require("express");
const itemController_1 = require("../controller/itemController");
const router = (0, express_1.Router)();
exports.router = router;
router.get('/', itemController_1.getItems);
router.get('/:id', itemController_1.getItem);
router.post('/', itemController_1.createItem);
router.put('/:id', itemController_1.update);
router.delete('/:id', itemController_1.deleteItem);
//# sourceMappingURL=itemRouter.js.map