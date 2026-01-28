import bcrypt from 'bcrypt'

const hashedPassword=bcrypt.hashSync("123456",10)

export const users=[
    {
        id:1,
        username:"admin",
        password:hashedPassword,
        role:"admin"
    }
] 
