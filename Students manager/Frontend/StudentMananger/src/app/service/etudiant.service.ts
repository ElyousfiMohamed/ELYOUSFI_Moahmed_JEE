import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Etudiant } from '../model/etudiant';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  private apServerUrl = '';

  constructor(private http: HttpClient) { }

  public getEtudiants(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(`${this.apServerUrl}/etudiants`);
  }

  public addEtudiant(etudiant: Etudiant): Observable<Etudiant> {
    return this.http.post<Etudiant>(`${this.apServerUrl}/etudiants`,etudiant);
  }

  public updateEtudiant(etudiant: Etudiant): Observable<Etudiant> {
    return this.http.put<Etudiant>(`${this.apServerUrl}/etudiants`,etudiant);
  }

  public deleteEtudiant(etudiantId: number): Observable<void> {
    return this.http.delete<void>(`${this.apServerUrl}/etudiants/delete/${etudiantId }`);
  }
  
}
