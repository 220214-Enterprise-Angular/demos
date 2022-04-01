import { UserMockService } from './../../services/user-mock.service';
import { UserService } from 'src/app/services/user.service';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { UserComponent } from './user.component';

describe('UserComponent', () => {
  let component: UserComponent;
  let fixture: ComponentFixture<UserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserComponent ],
      // providers dictate how services are injected/accomplish what they're designed to do
      providers: [{provide: UserService, useClass: UserMockService}]
    })
    /**
     * Service vs. Provider
     * A service is an object that exists in your application.
     * A provider is the WAY you gain access to that object
     */
    .compileComponents().then(() => {
      fixture = TestBed.createComponent(UserComponent);
      component = fixture.componentInstance;
    });
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // test that if the service provides ONE user in the array, we only render ONE user
  it (`should have one user`, waitForAsync(() => {

    expect(component.users.length).toEqual(1); // WHY? because the users component in this
                                               // testing environment retrieves only 1 user object from
                                               // the mock service.

  }))

  // check that IF on;ly 1 user in the service, only 1 user rendered
  it(`html should render one user`, waitForAsync(() => {

    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;

    expect(compiled.querySelector('p')?.innerText).toContain('user1');

  }))
});
