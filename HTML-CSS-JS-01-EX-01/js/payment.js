export function subtotal(amount, cost) {
    return amount * cost;
};

export function total(subtotal, iva) {
    return subtotal * iva;
};