import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  SERVER_URL = 'http://localhost:8080/report';

  constructor(private httpClient: HttpClient) {
  }

  merger(formData: FormData) {
    this.httpClient.post(this.SERVER_URL + '/merge', formData, { responseType: 'blob' } )
      .subscribe(
        response => {
          this.downLoadFile(response, 'application/octet-stream');
        },
        error => {
          console.log(error);
        },
        () => {
          console.log('File downloaded successfully');
        });
  }

  downLoadFile(data: any, type: string) {
    const blob = new Blob([data], { type: type });
    const url = window.URL.createObjectURL(blob);
    const pwa = window.open(url);
    // tslint:disable-next-line:triple-equals
    if (!pwa || pwa.closed || typeof pwa.closed === 'undefined') {
      alert( 'Please disable your Pop-up blocker and try again.');
    }
  }

}
