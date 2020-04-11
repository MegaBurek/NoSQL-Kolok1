import { Permission } from './permission';

export interface accountData {
    id: number;
    username: string;
    password: string;
    permission: Permission;
}