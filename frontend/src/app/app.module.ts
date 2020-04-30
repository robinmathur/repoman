import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ReportComponent } from './report/report.component';
import { NavigationComponent } from './navigation/navigation.component';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { AboutComponent } from './about/about.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbdDatepickerRangePopupComponent} from './utilities/date/date-range.component';
import {HttpClientModule} from '@angular/common/http';
import {ProformaComponent} from './proforma/proforma.component';
import {ProformaService} from './proforma/proforma.service';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'reports', component: ReportComponent },
  { path: 'proformas', component: ProformaComponent },
  { path: 'about', component: AboutComponent },
  { path: '**', component: NotfoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ReportComponent,
    NavigationComponent,
    HomeComponent,
    NotfoundComponent,
    AboutComponent,
    NgbdDatepickerRangePopupComponent,
    ProformaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    NgbModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    ProformaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
