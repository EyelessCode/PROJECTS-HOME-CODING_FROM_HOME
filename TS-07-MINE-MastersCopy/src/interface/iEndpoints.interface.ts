import { IClienteObject } from "./iClient.interface";

export interface IEndpointsInterface {
    getAll():IClienteObject[]
    getById(code:number):IClienteObject|undefined
    // getByEmail(getEmail:string):IClienteObject|undefined
    create(client:IClienteObject):IClienteObject
    update(code:number,client:IClienteObject):IClienteObject|undefined
    delete(code:number):boolean
}