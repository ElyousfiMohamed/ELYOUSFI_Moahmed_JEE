import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Etudiant } from '../model/etudiant';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private apServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getEtudiants(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(`${this.apServerUrl}/etudiants`);
  }

  public getEtudiantsByKw(keyword: string | undefined): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(`${this.apServerUrl}/etudiants/${keyword}`);
  }

  public addEtudiant(etudiant: Etudiant): Observable<Etudiant> {
    return this.http.post<Etudiant>(`${this.apServerUrl}/etudiants`,etudiant);
  }

  public updateEtudiant(etudiant: Etudiant): Observable<Etudiant> {
    console.log(etudiant);
    return this.http.put<Etudiant>(`${this.apServerUrl}/etudiants/`+etudiant.id,etudiant);
  }

  public deleteEtudiant(etudiantId: number): Observable<void> {
    return this.http.delete<void>(`${this.apServerUrl}/etudiants/${etudiantId}`);
  }

  public getRandom(): Observable<Etudiant> {
    return this.http.get<Etudiant>(`${this.apServerUrl}/etudiant`);
  }
}
