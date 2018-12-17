import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FormSharedModule } from 'app/shared';
import {
    WxUserComponent,
    WxUserDetailComponent,
    WxUserUpdateComponent,
    WxUserDeletePopupComponent,
    WxUserDeleteDialogComponent,
    wxUserRoute,
    wxUserPopupRoute
} from './';

const ENTITY_STATES = [...wxUserRoute, ...wxUserPopupRoute];

@NgModule({
    imports: [FormSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [WxUserComponent, WxUserDetailComponent, WxUserUpdateComponent, WxUserDeleteDialogComponent, WxUserDeletePopupComponent],
    entryComponents: [WxUserComponent, WxUserUpdateComponent, WxUserDeleteDialogComponent, WxUserDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FormWxUserModule {}
