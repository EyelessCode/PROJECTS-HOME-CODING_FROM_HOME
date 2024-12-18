export function ivaEnter(price) {
    let iva=0.15
    let result=price*iva
    return result;
}

export function subtotalEnter(price,ivaEnter) {
    let result=price+ivaEnter
    return Number(result).toFixed(2);
}

export function totalEnter(subtotalEnter,ivaEnter) {
    let result=subtotalEnter+ivaEnter;
    return Number(result).toFixed(2);

}

//todo: ADITIONAL MEAL FUNTIONS
export function aditionalMealEnter(price,aditional) {
    return (Number(price)+Number(aditional)).toFixed(2);
}

export function aditionalIvaEnter(priceAndAditional,ivaRemove) {
    // let remove=ivaRemove-ivaRemove;
    let iva=0.15
    return (Number(priceAndAditional)*iva).toFixed(2);
}

export function aditionalSubtotalEnter(priceAndAditional,aditionalIvaEnter) {
    return (Number(priceAndAditional)+Number(aditionalIvaEnter)).toFixed(2);
}

export function aditionalTotalEnter(aditionalSubtotalEnter,ivaEnter) {
    return (Number(aditionalSubtotalEnter)+Number(ivaEnter)).toFixed(2);
}