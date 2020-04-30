import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ReportService} from './report.service';
import {ReportType} from '../model/reporttype';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  userForm: FormGroup;
  reportTypes: string[] = [];
  files = new Map<string, any>();

  constructor(private formBuilder: FormBuilder, private reportService: ReportService) {
  }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group(
      {
        reportTitle: [''],
        reportType: [''],
        dateTo: [''],
        dateFrom: [''],
        reports: ['']
      }
    );
    for (const reportType in ReportType) {
      if (isNaN(Number(reportType))) {
        this.reportTypes.push(reportType);
      }
    }
  }

  submit() {
    const formData = new FormData();
    formData.set('reportTitle', this.userForm.get('reportTitle').value);
    formData.set('reportType', this.userForm.get('reportType').value);
    formData.set('dateTo', this.userForm.get('dateTo').value);
    formData.set('dateFrom', this.userForm.get('dateFrom').value);
    this.files.forEach((value, key) => {
      formData.append('files', value);
    });
    this.reportService.merger(formData);
  }

  selectFile(event) {
    for (const file of event.target.files) { this.files.set(file.name, file); }
    event.target.value = null;
  }

  removeFile(fileName) {
    this.files.delete(fileName);
  }
}
