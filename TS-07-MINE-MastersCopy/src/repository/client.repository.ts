import { OBJECT_CLIENT } from '../data/client.data';
import { IClientObject } from '../interface/iClient.interface';
import { IEndpointsInterface } from "../interface/iEndpoints.interface";

export class ClientRepository implements IEndpointsInterface{

    private clientes:IClientObject[]=OBJECT_CLIENT
    
    getAll(): IClientObject[] {
        // throw new Error("Method not implemented.");
        return this.clientes
    }

    getById(code: number): IClientObject | undefined {
        // throw new Error("Method not implemented.");
        return this.clientes.find((clientFind)=>clientFind.id===code)
    }

    create(client: IClientObject): IClientObject {
        // throw new Error("Method not implemented.");
        this.clientes.push(client)
        return client
    }

    update(code: number, client: IClientObject): IClientObject | undefined {
        // throw new Error("Method not implemented.");
        let index=this.clientes.findIndex((indexClient)=>indexClient.id===code)
        if (index!==1) {
            this.clientes[index]={...client,id:code}
            return this.clientes[index]
        }
        return undefined
    }

    delete(code: number): boolean {
        // throw new Error("Method not implemented.");
        let index=this.clientes.findIndex((indexClient)=>indexClient.id===code)
        if (index!==-1) {
            this.clientes.splice(index,1)
            return true;
        }
        return false
    }

}