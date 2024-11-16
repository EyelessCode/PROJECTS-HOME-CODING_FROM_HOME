export function first(x) {
    let salario;
    let hourA;
    let hourC;
    let contributionPercen;
    
    const totalHour=hourA*hourC;
    const salaryPlus=salario+totalHour;
    const additionalAmount=salaryPlus*(contributionPercen/100);
    const netReceive=salaryPlus-additionalAmount;
};