export function ivaEnter(price) {
    let iva=0.15
    let result=price*iva
    return result;
}

export function subtotalEnter(price,ivaEnter) {
    let result=price+ivaEnter
    return result;
}

export function totalEnter(subtotalEnter,ivaEnter) {
    let result=subtotalEnter+ivaEnter;
    return result;

}