import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  credentials = {username: '', password: ''};

  constructor(private auth: AuthenticationService, private http: HttpClient, private router: Router) {
   this.auth.authenticate(undefined, undefined);}
  authenticated = this.auth.authenticated;

  login() {
    this.auth.authenticate(this.credentials, () => {
        this.router.navigateByUrl('/');
    });
    return false;
  }
      logout() {
        this.http.post('logout', {}).finally(() => {
            this.auth.authenticated = false;
            this.router.navigateByUrl('/login');
        }).subscribe();
      }
  ngOnInit(): void {
  }

}
