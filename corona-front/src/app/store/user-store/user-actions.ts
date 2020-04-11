import { User } from '../../model/user';

export class GetUsers {
    static readonly type = '[user] GetUsers';

    constructor() { }
}

export class GetUser {
    static readonly type = '[user] GetUser';

    constructor(public userID: number) { }
}

export class DeleteUser {
    static readonly type = '[user] DeleteUser';

    constructor(public id: number) { }
}

export class AddUser {
    static readonly type = '[user] AddUser';

    constructor(public user: User) { }
}
