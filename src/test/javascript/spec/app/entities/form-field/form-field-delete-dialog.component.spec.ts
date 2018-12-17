/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { FormTestModule } from '../../../test.module';
import { FormFieldDeleteDialogComponent } from 'app/entities/form-field/form-field-delete-dialog.component';
import { FormFieldService } from 'app/entities/form-field/form-field.service';

describe('Component Tests', () => {
    describe('FormField Management Delete Component', () => {
        let comp: FormFieldDeleteDialogComponent;
        let fixture: ComponentFixture<FormFieldDeleteDialogComponent>;
        let service: FormFieldService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [FormTestModule],
                declarations: [FormFieldDeleteDialogComponent]
            })
                .overrideTemplate(FormFieldDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FormFieldDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FormFieldService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
