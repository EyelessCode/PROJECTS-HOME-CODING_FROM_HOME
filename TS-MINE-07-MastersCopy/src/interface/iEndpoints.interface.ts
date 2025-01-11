import { IClientObject } from "./iClient.interface";

export interface IEndpointsInterface {
    getAll():IClientObject[]
    getById(code:number):IClientObject|undefined
    // getByEmail(getEmail:string):IClienteObject|undefined
    create(client:IClientObject):IClientObject
    update(code:number,client:IClientObject):IClientObject|undefined
    delete(code:number):boolean
}