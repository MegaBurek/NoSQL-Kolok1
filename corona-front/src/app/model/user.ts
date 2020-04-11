import { accountData } from './accountData';

export interface User {
    id: number;
    name: String;
    surname: String;
    accountData: accountData;
}