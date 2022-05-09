import { HttpErrorResponse } from '@angular/common/http';
import {Component, Input, OnInit} from '@angular/core';
import { EtudiantService } from 'src/app/service/etudiant.service';
import { Etudiant,Genre } from '../../model/etudiant';

@Component({
  selector: 'app-root',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {
  public etudiants: Etudiant[] = [];

  constructor(private etudiantSRV: EtudiantService) { }

  etudiantCurrent: Etudiant = this.etudiants[0];

  ngOnInit(): void {
    this.getEtudiants();
  }

  public getEtudiants(): void {
    this.etudiantSRV.getEtudiants().subscribe(
      (response: Etudiant[]) => {
        this.etudiants = response;
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public currentEtudiant(etudiantCurrent: Etudiant){
    this.etudiantCurrent = etudiantCurrent;
  }

  getIt() {
    this.getEtudiants();
  }

  getSearch(etudiantsSearch: Etudiant[]) {
      this.etudiants = etudiantsSearch;
  }
}
