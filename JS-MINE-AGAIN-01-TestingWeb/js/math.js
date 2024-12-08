export function ivaEnter(price) {
    // iva=0.15
    let result=price*0.15
    return result;
}

export function subtotalEnter(price,iva) {
    let result=price+iva
    return result;
}

export function totalEnter(subtotalEnter,iva) {
    let result=subtotalEnter+iva;
    return result;

}