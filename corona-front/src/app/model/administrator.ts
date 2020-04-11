import { accountData } from './accountData';

export interface Administrator {
    id: number;
    name: String;
    surname: String;
    accountData: accountData;
}