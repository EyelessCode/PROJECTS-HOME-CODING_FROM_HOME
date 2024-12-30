import { OBJECT_CLIENT } from "../data/cliente.data";
import { IClienteObject } from "../interface/iCliente.interface";
import { IEndpointsInterface } from "../interface/iEndpoints.interface";

export class ClienteRepository implements IEndpointsInterface{

    private clientes:IClienteObject[]=OBJECT_CLIENT
    
    getAll(): IClienteObject[] {
        // throw new Error("Method not implemented.");
        return this.clientes
    }
    getById(code: number): IClienteObject | undefined {
        throw new Error("Method not implemented.");
    }
    create(code: number): IClienteObject {
        throw new Error("Method not implemented.");
    }
    update(code: number, client: IClienteObject): IClienteObject | undefined {
        throw new Error("Method not implemented.");
    }
    delete(code: number): boolean {
        throw new Error("Method not implemented.");
    }

}