import { State, Action, StateContext, Selector } from '@ngxs/store';
import { tap } from 'rxjs/operators';
import { GetUsers, DeleteUser, AddUser, GetUser } from './user-actions';
import { User } from 'src/app/model/user';
import { UserService } from '../../services/user/user.service';

export class UserStateModel {
    users: User[];
    selectedUser: User;
}

@State<UserStateModel>({
    name: 'user',
    defaults: {
        users: [],
        selectedUser: { id: null, name: null,  surname: null, accountData: null}
    }
})
export class ClientState {

    constructor(private userService: UserService) {
    }

    @Selector()
    static getSelectedClients(state: UserStateModel) {
        return state.users;
    }

    @Selector()
    static getClient(state: UserStateModel) {
        return state.selectedUser;
    }


    @Action(GetUsers)
    getClients({ patchState }: StateContext<UserStateModel>) {
        return this.userService.getUsers().pipe(tap((newUsers) => {
            patchState({
                users: newUsers
            });
        }));
    }

    @Action(GetUser)
    getClient({ patchState }: StateContext<UserStateModel>, { userID }: GetUser) {
        return this.userService.getUser(userID).pipe(tap((user) => {
            patchState({
                selectedUser: user
            });
        }));
    }

    @Action(DeleteUser)
    deleteClient({ getState, patchState }: StateContext<UserStateModel>, { id }: DeleteUser) {
        return this.userService.deleteUser(id).pipe(tap((user) => {
            const state = getState();
            const filteredClients = state.users.filter(user => user.id !== id);
            patchState({
                users: [...filteredClients]
            });
        }));
    }

    @Action(AddUser)
    addClient({ getState, patchState }: StateContext<UserStateModel>, { user }: AddUser) {
        return this.userService.addUser(user).pipe(tap((resultUser) => {
            const state = getState();
            patchState({
                users: [...state.users, resultUser]
            });
        }));
    }
}
