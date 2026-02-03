import type { JwtPayload } from 'jsonwebtoken';
import type { UserPayload } from './src/middlewares/@types/user.types';

declare global{
    namespace Express{
        interface Request{
            user?:UserPayload|JwtPayload
        }
    }
}
