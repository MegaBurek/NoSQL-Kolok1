import { Administrator } from '../../model/administrator';

export class GetAdmins {
    static readonly type = '[administrator] GetAdministrators';

    constructor() { }
}

export class GetAdministrator {
    static readonly type = '[administrator] GetAdministrator';

    constructor(public userID: number) { }
}

export class DeleteAdministrator {
    static readonly type = '[administrator] DeleteAdministrator';

    constructor(public id: number) { }
}

export class AddAdministrator {
    static readonly type = '[administrator] AddAdministrator';

    constructor(public admin: Administrator) { }
}
