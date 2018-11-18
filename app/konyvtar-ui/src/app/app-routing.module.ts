import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SearchModalComponent} from './menubar/search/search-modal.component';

const routes: Routes = [
	{ path: 'search', component: SearchModalComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
