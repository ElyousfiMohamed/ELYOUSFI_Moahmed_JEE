import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Etudiant} from "../../model/etudiant";
import {EtudiantService} from "../../service/etudiant.service";
import {NgForm} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.css']
})
export class DeleteModalComponent implements OnInit {
  @Input() etudiant!: Etudiant;
  constructor(private etudiantSRV: EtudiantService) { }

  ngOnInit(): void {
    this.etudiantSRV.getEtudiants().subscribe((response: Etudiant[]) => {
      this.etudiant = response[0];
    })
  }

  @Output()
  notify1:EventEmitter<void> = new EventEmitter<void>();

  onDeleteEtudiant(etudiantId:number): void {
    document.getElementById('closeIt')!.click();
    this.etudiantSRV.deleteEtudiant(etudiantId).subscribe(
      (response: void) => {
        this.notify1.emit();
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      });
  }
}
