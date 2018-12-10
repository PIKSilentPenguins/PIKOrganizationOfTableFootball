import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ListUserComponent} from './list-user/list-user.component';
import {EditUserComponent} from './edit-user/edit-user.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register-user', component: RegisterComponent},
  {path: 'list-user', component: ListUserComponent},
  {path: 'edit-user', component: EditUserComponent},
  {path: 'logout-user', component: LoginComponent},
  {path: '', component: ListUserComponent}
];

export const routing = RouterModule.forRoot(routes);
