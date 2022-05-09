import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {NgForm} from "@angular/forms";
import { EtudiantService } from 'src/app/service/etudiant.service';
import {Etudiant} from "../../model/etudiant";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-add-modal',
  templateUrl: './add-modal.component.html',
  styleUrls: ['./add-modal.component.css']
})
export class AddModalComponent implements OnInit {
  constructor(private etudiantSRV: EtudiantService) { }

  ngOnInit(): void {
  }

  @Output()
  notify:EventEmitter<void> = new EventEmitter<void>();

  onAddEtudiant(addForm: NgForm): void {
    document.getElementById('close')!.click();
    this.etudiantSRV.addEtudiant(addForm.value).subscribe(
      (response: Etudiant) => {
        this.notify.emit();
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      });
  }
}
