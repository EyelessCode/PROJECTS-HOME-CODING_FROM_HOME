import { ClientRepository } from "./repository/client.repository";

let repository:ClientRepository=new ClientRepository()

repository.getAll().forEach((client)=>console.log(
    `IC: ${client.ic}, name: ${client.name}`
))
repository.delete(6)
repository.getAll().forEach((client)=>console.log(
    `IC: ${client.ic}, name: ${client.name}`
))