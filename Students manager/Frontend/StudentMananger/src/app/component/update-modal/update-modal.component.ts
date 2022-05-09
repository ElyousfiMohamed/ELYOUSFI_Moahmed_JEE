import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {EtudiantService} from "../../service/etudiant.service";
import {NgForm} from "@angular/forms";
import {Etudiant} from "../../model/etudiant";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-update-modal',
  templateUrl: './update-modal.component.html',
  styleUrls: ['./update-modal.component.css']
})
export class UpdateModalComponent implements OnInit {
  @Input() etudiant!: Etudiant;
  constructor(private etudiantSRV: EtudiantService) { }

  ngOnInit(): void {
    this.etudiantSRV.getEtudiants().subscribe((response: Etudiant[]) => {
      this.etudiant = response[0];
    })
  }

  @Output()
  notify0:EventEmitter<void> = new EventEmitter<void>();

  onUpdateEtudiant(updateForm: NgForm): void {
    document.getElementById('closed')!.click();
    this.etudiantSRV.updateEtudiant(updateForm.value).subscribe(
      (response: Etudiant) => {
        this.notify0.emit();
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      });
  }
}
