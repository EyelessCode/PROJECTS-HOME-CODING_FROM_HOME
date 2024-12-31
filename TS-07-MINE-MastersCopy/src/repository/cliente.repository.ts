import { OBJECT_CLIENT } from "../data/cliente.data";
import { IClienteObject } from '../interface/iCliente.interface';
import { IEndpointsInterface } from "../interface/iEndpoints.interface";

export class ClienteRepository implements IEndpointsInterface{

    private clientes:IClienteObject[]=OBJECT_CLIENT
    
    getAll(): IClienteObject[] {
        // throw new Error("Method not implemented.");
        return this.clientes
    }

    getById(code: number): IClienteObject | undefined {
        // throw new Error("Method not implemented.");
        return this.clientes.find((clienteFind)=>clienteFind.id===code)
    }

    create(client: IClienteObject): IClienteObject {
        // throw new Error("Method not implemented.");
        this.clientes.push(client)
        return client
    }

    update(code: number, client: IClienteObject): IClienteObject | undefined {
        // throw new Error("Method not implemented.");
        let index=this.clientes.findIndex((indexClient)=>indexClient.id===code)
        if (index!=1) {
            this.clientes[index]={...client,id}
            return this.clientes[index]
        }
        return undefined
    }

    delete(code: number): boolean {
        throw new Error("Method not implemented.");
    }

}