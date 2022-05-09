import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {EtudiantService} from "../../service/etudiant.service";
import {Etudiant} from "../../model/etudiant";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private etudiantSRV:EtudiantService) { }

  public etudiants0: Etudiant[] = [];
  @Input() etudiants1!: Etudiant[];

  @Output()
  notify2:EventEmitter<Etudiant[]> = new EventEmitter<Etudiant[]>();

  @Output()
  notify3:EventEmitter<void> = new EventEmitter<void>();

  ngOnInit(): void {
  }

  search(kw: string) {
    this.etudiants0 = [];
    for (const etudiant of this.etudiants1) {
      if(etudiant.prenom.toLowerCase().indexOf(<string>kw.toLowerCase()) !== -1
      || etudiant.nom.toLowerCase().indexOf(<string>kw.toLowerCase()) !== -1
      || etudiant.email.toLowerCase().indexOf(<string>kw.toLowerCase()) !== -1) {
        this.etudiants0.push(etudiant);
      }
    }
    if(kw === "")
      this.notify3.emit()

    this.notify2.emit(this.etudiants0)
  }
}
