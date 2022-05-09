import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './component/app.component';
import { EtudiantComponent } from './component/etudiant/etudiant.component';
import {EtudiantService} from "./service/etudiant.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { NavbarComponent } from './component/navbar/navbar.component';
import { AddModalComponent } from './component/add-modal/add-modal.component';
import { UpdateModalComponent } from './component/update-modal/update-modal.component';
import { DeleteModalComponent } from './component/delete-modal/delete-modal.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent,
    NavbarComponent,
    AddModalComponent,
    UpdateModalComponent,
    DeleteModalComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EtudiantService],
  bootstrap: [EtudiantComponent]
})
export class AppModule { }
