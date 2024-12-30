import { IClienteObject } from "./iCliente.interface";

export interface IEndpointsInterface {
    getAll():IClienteObject[]
    getById(code:number):IClienteObject|undefined
    // getByEmail(getEmail:string):IClienteObject|undefined
    create(code:number):IClienteObject
    update(code:number,client:IClienteObject):IClienteObject|undefined
    delete(code:number):boolean
}