package net.greeta.video.controller.storage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import net.greeta.video.data.UserDetail;
import net.greeta.video.data.storage.UploadRequest;
import net.greeta.video.service.storage.ObjectStorageService;
import net.greeta.video.service.user.auth.UserDetailService;
import net.greeta.video.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/api/storage") // path prefix
public class StorageController {
  @Autowired
  ObjectStorageService objectStorageService;
  @Autowired
  UserDetailService userDetailService;

  @Operation(description = "upload video file")
  @ApiResponses
  @RequestMapping(
      path = "/upload",
      method = RequestMethod.POST,
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity upload(@Valid UploadRequest request) throws Exception {
    UserDetail user = AuthUtil.currentUserDetail();
    userDetailService.createUserIfAbsent(user.getUsername());
    MultipartFile file = request.getFile();
    String objectName = "user/" + user.getId() + "/" + request.getFileName();
    try {
      // upload
      objectStorageService.upload(file, objectName);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return ResponseEntity.ok().build();
  }

  /*@AuthenticatedApi
  @RequestMapping(path = "/download", method = RequestMethod.GET)
  public void download(@ParameterObject @Valid DownloadRequest request,
                                 HttpServletRequest servletRequest,
                                 HttpServletResponse servletResponse) {
      UserDetail user = AuthUtil.currentUserDetail();
      String objectName = "user/"+user.getId()+"/"+request.getFileName();
      try {
          objectStorageService.download(objectName, request.getFileName(), servletRequest, servletResponse);
      } catch (DoesNotExist e) {
          servletResponse.setStatus(404);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }*/

  /*@AuthenticatedApi
  @RequestMapping(path = "/file", method = RequestMethod.GET)
  public ResponseEntity getFile(@ParameterObject @Valid FileRequest request) {

  }*/

  /*
  @AuthenticatedApi
  @RequestMapping(path = "/file", method = RequestMethod.DELETE)
  public ResponseEntity deleteFile(@ParameterObject @Valid FileRequest request) {
      UserDetail user = AuthUtil.currentUserDetail();
      try {
          fileService.delete(user.getId(), request.getPath(), false);
      }catch (DoesNotExist e){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok().build();
  }*/

  /*@AuthenticatedApi
  @RequestMapping(path = "/folder", method = RequestMethod.POST)
  public ResponseEntity createFolder(@RequestBody @Valid FolderRequest request) {
      UserDetail user = AuthUtil.currentUserDetail();
      String folderName = request.getPath().substring(request.getPath().lastIndexOf("/")+1);
      try {
          fileService.createFolder(user.getId(), request.getPath(), folderName);
      }catch (InvalidOperation e) {
          throw new RuntimeException(e);
      }
      return ResponseEntity.ok().build();
  }*/

  /*@AuthenticatedApi
  @RequestMapping(path = "/folder", method = RequestMethod.GET)
  public ResponseEntity getFolder(@ParameterObject @Valid FolderRequest request) {
      try {
          return ResponseEntity.ok(new FileResponse(
                  fileService.get(AuthUtil.currentUserDetail().getId(), request.getPath(), true)
          ));
      }catch (DoesNotExist e){
          return ResponseEntity.notFound().build();
      }
  }*/

  /*@AuthenticatedApi
  @RequestMapping(path = "/folder", method = RequestMethod.DELETE)
  public ResponseEntity deleteFolder(@ParameterObject @Valid FolderRequest request) {
      UserDetail user = AuthUtil.currentUserDetail();
      try {
          fileService.delete(user.getId(), request.getPath(), true);
      }catch (DoesNotExist e){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok().build();
  }*/
}
