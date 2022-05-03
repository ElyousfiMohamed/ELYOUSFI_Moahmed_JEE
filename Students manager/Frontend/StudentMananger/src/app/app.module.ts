import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './component/app.component';
import { EtudiantComponent } from './component/etudiant/etudiant.component';

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [EtudiantComponent]
})
export class AppModule { }
