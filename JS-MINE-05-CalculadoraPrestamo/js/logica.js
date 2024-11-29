export function mensual(montoPrestamo, TasaInteresMensual, periodoMeses) {
    let pago = montoPrestamo * (TasaInteresMensual * Math.pow(1 + TasaInteresMensual, periodoMeses)) /
        (Math.pow(1 + TasaInteresMensual, periodoMeses) - 1);
    return pago;
};

export function interesCompuesto(montoPrestamo,TasaInteresMensual,periodoMeses) {
    let pagoMensual=mensual(montoPrestamo,TasaInteresMensual,periodoMeses);
    let totalPagado=pagoMensual*periodoMeses;
    let interesTotal=totalPagado-montoPrestamo;
    return interesTotal;
};