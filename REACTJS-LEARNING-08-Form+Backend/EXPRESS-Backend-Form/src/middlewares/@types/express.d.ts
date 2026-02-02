import type { JwtPayload } from 'jsonwebtoken';
import type { UserPayload } from './user.types';

declare global{
    namespace Express{
        interface Request{
            user?:UserPayload|JwtPayload
        }
    }
}
