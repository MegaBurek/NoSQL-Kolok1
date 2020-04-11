import { State, Action, StateContext, Selector } from '@ngxs/store';
import { tap } from 'rxjs/operators';
import { GetAdministrator, GetAdmins, DeleteAdministrator, AddAdministrator } from './administrator-actions';
import { Administrator } from '../../model/administrator';
import { AdministratorService } from 'src/app/services/administrator/administrator.service';

export class AdministratorStateModel {
    administrators: Administrator[];
    selectedAdmin: Administrator;
}

@State<AdministratorStateModel>({
    name: 'admin',
    defaults: {
        administrators: [],
        selectedAdmin: { id: null, name: null,  surname: null, accountData: null}
    }
})
export class ClientState {

    constructor(private adminService: AdministratorService) {
    }

    @Selector()
    static getSelectedClients(state: AdministratorStateModel) {
        return state.administrators;
    }

    @Selector()
    static getClient(state: AdministratorStateModel) {
        return state.selectedAdmin;
    }


    @Action(GetAdmins)
    getClients({ patchState }: StateContext<AdministratorStateModel>) {
        return this.adminService.getUsers().pipe(tap((newUsers) => {
            patchState({
                administrators: newUsers
            });
        }));
    }

    @Action(GetAdministrator)
    getClient({ patchState }: StateContext<AdministratorStateModel>, { userID }: GetAdministrator) {
        return this.adminService.getUser(userID).pipe(tap((user) => {
            patchState({
                selectedAdmin: user
            });
        }));
    }

    @Action(DeleteAdministrator)
    deleteClient({ getState, patchState }: StateContext<AdministratorStateModel>, { id }: DeleteAdministrator) {
        return this.adminService.deleteUser(id).pipe(tap((admin) => {
            const state = getState();
            const filteredClients = state.administrators.filter(admin => admin.id !== id);
            patchState({
                administrators: [...filteredClients]
            });
        }));
    }

    @Action(AddAdministrator)
    addClient({ getState, patchState }: StateContext<AdministratorStateModel>, { admin }: AddAdministrator) {
        return this.adminService.addUser(admin).pipe(tap((resultAdmin) => {
            const state = getState();
            patchState({
                administrators: [...state.administrators, resultAdmin]
            });
        }));
    }
}
